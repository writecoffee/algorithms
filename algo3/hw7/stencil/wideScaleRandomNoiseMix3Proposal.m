function out=wideScaleRandomNoiseMix3Proposal(x)
% Runs a random one of the three wideScaleRandomNoise proposal functions on
% the input

if (numel(x) > 1)
    r = randi([1,3], 1, 1);
    switch r
    case 1
        out = wideScaleRandomNoiseProposal(x);
    case 2
        out = wideScaleRandomNoiseOneCoordinateProposal(x);
    case 3
        out = wideScaleRandomNoisePairProposal(x);
    end
else
    out = wideScaleRandomNoiseProposal(x);
end
