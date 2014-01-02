% Empty file! Put whatever you want here

function [E]=bilbwopRunner()

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --------------------------------------------- PART 1 ---------------------------------------------------------
% ----  Good Start Found:
%
%           When we experiment on the web game, we could make use of the physical law such that 
%       every time in order to make progress we would use one leg as the supporting point and use another 
%       to stretch as much as it could after 'flying' upright but in the meanwhile the first leg should
%       help keeping the body balance and thus need to step up. When the second foot launches, it becomes
%       the supporting point for the next move. 
%           The circle would continue if there are no steps limit. To mimic this progress, we 
%       construct the vector to approximate this physical law and use 'wideScaleRandomNoiseOneCoordinateProposal',
%       mildly approximating the best move obeying the physical law.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

startingX = [[1,   1]; [1,   1]; [1,   1]; [1,   1]; [1,   1]; [1,   -1]; [1,   -1]; [1,   -1]; [1,   -1]; [1,   -1]; [-1,  1]; [-1,  1]; [-1,  1]; [-1,  1]; [-1,  1]; [-1,  -1]; [-1,  -1]; [-1,  -1]; [-1,  -1]; [-1,  -1]];


E = startingX;
funcToOptimize = @bilbwop;
proposalFunc = @wideScaleRandomNoiseOneCoordinateProposal
startingX = E;
drawable = 0;
timeDelta = 10;
funcDelta = 0.00;
epsilon = 0.01;
timeout = 0;
accepted = 0;
valueDelta = 0;
currentTime = 0;
funcPropPair = [0, 0];
funcOrig = 0;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --------------------------------------------- PART 2 ---------------------------------------------------------
% ----  Optimizing the 'Jogging' cycle
%           Using the approach mentioned above, it would make approximately 6-meter progress after several experiments.
%       We set the 'epsilon' value to be 0.01 in order to accept more tries due to the mild optimization.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

while funcToOptimize(startingX) > -6
    timeout = 0;
    starttime = now * 60 * 60 * 24;
    timeAllowed = timeDelta;
    if drawable == 1
        funcOrig = funcToOptimize(startingX, 1)
    else
        funcOrig = funcToOptimize(startingX)
    end

    valueDelta = 0;

    randIndex = randi(size(E, 1));
    funcOrigPair = E(randIndex,1:2);
    while 1
        % check boundary
        funcPropPair = proposalFunc(funcOrigPair);
        while (funcPropPair(1) > 1 || funcPropPair(1) < -1 || funcPropPair(2) > 1 || funcPropPair(2) < -1)
            funcPropPair = proposalFunc(funcOrigPair); 
        end

        % evaluate proposed value's improvement 
        tmp = E;
        tmp(randIndex,1:2) = funcPropPair;
        funcProp = bilbwop(tmp);
        valueDelta = funcProp - funcOrig;
        if valueDelta < 0 || (valueDelta >= 0 && valueDelta < epsilon)
            if valueDelta < 0
                E(randIndex,1:2) = funcPropPair;
            end
            accepted = 1;

            % break the while loop if we found the improved 'xp' or accpetable degeneration
            break;
        end
    end

    startingX(randIndex,1:2) = funcPropPair;
end


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% --------------------------------------------- PART 3 ---------------------------------------------------------
% ----  Optimizing the Last Step
%           After finishing the Jogging obeying the physical law, we find that we could still make progress if 
%       we make full use of the last several steps in order to jump as far as it could in the last moment.
%       So in this aggressive process, we do not allow any more degeneration value. 
%           The result turns out to be very funny such that the stick man would do complicated action.
%           Also we set the time limit to be 100000 in order to break the function if there is not much progress.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

E = startingX;
proposalFunc = @wideScaleRandomNoiseMix3Proposal;
startingX = E;
timeDelta = 100000;
funcDelta = 0.001;
timeout = 0;
accepted = 0;
valueDelta = 0;
funcPropPair = [0, 0];
funcOrig = 0;

% timeDelta seconds have passed and the best value found in this stack imrpoves not much
while ~(timeout == 1 && (valueDelta > 0  || (abs(valueDelta) / funcOrig) <= funcDelta))
    timeout = 0;
    starttime = now * 60 * 60 * 24;
    timeAllowed = timeDelta;
    if drawable == 1
        funcOrig = funcToOptimize(startingX, 1)
    else
        funcOrig = funcToOptimize(startingX)
    end

    valueDelta = 0;

    randIndex = randi(size(E, 1));
    funcOrigPair = E(randIndex,1:2);
    while timeout == 0
        % check boundary
        funcPropPair = proposalFunc(funcOrigPair);
        while (funcPropPair(1) > 1 || funcPropPair(1) < -1 || funcPropPair(2) > 1 || funcPropPair(2) < -1)
            funcPropPair = proposalFunc(funcOrigPair); 
        end

        % evaluate proposed value's improvement 
        tmp = E;
        tmp(randIndex,1:2) = funcPropPair;
        funcProp = bilbwop(tmp);
        valueDelta = funcProp - funcOrig;
        if valueDelta < 0
            if valueDelta < 0
                E(randIndex,1:2) = funcPropPair;
            end
            accepted = 1;

            % break the while loop if we found the improved 'xp' or accpetable degeneration
            break;
        end

        % evaluate the time limit
        timenow = now * 60 * 60 * 24;
        timeAllowed = timeAllowed - (timenow - starttime);
        if timeAllowed < 0 
            timeout = 1;
            break
        end
    end

    startingX(randIndex,1:2) = funcPropPair;
end
