function out=wideScaleRandomNoiseOneCoordinateProposal(x)
% Changes a random coordinate of x by a random amount at a random scale
% chosen in an exponential fashion from a range at least [.0001,100]

r = -4 + 6 .* rand(1, 1);
radius = 10 .^ r;
rpnnum = randn(size(x));
xp = radius .* rpnnum + x;
singleentry = randi([1, numel(x)], 1, 1);
%x[singleentry] = xp(singleentry);
xp(singleentry) = x(singleentry);
out = xp;
