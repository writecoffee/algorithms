%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
% 
% >> result=arrangeCirclesRunner(pos)
% 
% result =
% 
%   Columns 1 through 5
% 
%    23.9967   38.2839   26.2334    4.7362   35.9994
%    40.6387   16.6968    5.3843   25.4128    6.6407
% 
%   Columns 6 through 10
% 
%     6.5759   16.9051   27.7585   31.9994   10.4827
%    35.7190   27.6617   16.6949   33.1574   11.6407
% 
% >> arrangeCircles(result)
% 
% ans =
% 
%    40.5168
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 

function out=arrangeCirclesRunner(pos)

% global variables
funcToOptimize = @arrangeCircles;
proposalFunc = @wideScaleRandomNoisePairProposal;
drawable = 1;
timeDelta = 1;
funcDelta = 0.9;
lowerBoundOnX = 1;
upperBoundOnX = 45;
startingX = pos;
epsilon = 0;
timeout = 0;
accepted = 0;
valueDelta = 0;
out = startingX;
xp = startingX;

% timeDelta seconds have passed and the best value found in this stack imrpoves not much
while ~(timeout == 1 && (valueDelta > 0 || (abs(valueDelta) / funcOrig) <= funcDelta))


    %set(0, 'RecursionLimit', 2000);

    timeout = 0;
    starttime = now * 60 * 60 * 24;
    timeAllowed = timeDelta;
    if drawable == 1
        funcOrig = funcToOptimize(startingX, 1);
    else
        funcOrig = funcToOptimize(startingX);
    end
    valueDelta = 0;

    while timeout == 0
        % check boundary
        xp = proposalFunc(startingX);
        while min(min(xp)) < lowerBoundOnX || max(max(xp)) > upperBoundOnX
            xp = proposalFunc(startingX);
        end
            
        % evaluate proposed value's improvement
        funcProp = funcToOptimize(xp);
        valueDelta = funcProp - funcOrig;
        if valueDelta < 0 || (valueDelta >= 0 && valueDelta <= epsilon)
            % break the while loop if we found the improved 'xp'
            out = xp;
            accepted = 1;
            break
        end

        % evaluate the time limit
        timenow = now * 60 * 60 * 24;
        timeAllowed = timeAllowed - (timenow - starttime);
        if timeAllowed < 0 
            timeout = 1;
        end
    end

    startingX = xp;
end
