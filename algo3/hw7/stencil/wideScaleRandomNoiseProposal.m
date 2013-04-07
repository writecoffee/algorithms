function out=wideScaleRandomNoiseProposal(x)
% Changes all coordinates of x by a random amount at a random scale chosen
% in an exponential fashion from a range at least [.0001,100]

r = -4 + 6 .* rand(1, 1);
radius = 10 .^ r;
rpnnum = randn(size(x));
out = radius .* rpnnum + x;
