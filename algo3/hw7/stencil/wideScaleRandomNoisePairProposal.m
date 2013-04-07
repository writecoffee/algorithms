function out=wideScaleRandomNoisePairProposal(x)
% Changes two random coordinates 2i-1 and 2i of x by a random amount at a 
% random scale chosen in an exponential fashion from a range at least
% [.0001,100] 

tmpX = x;
r = -4 + 6 .* rand();
radius = 10 .^ r;
rpnnum = randn(size(x));
xp = radius .* rpnnum + x;
n = floor(numel(x) / 2);
i = randi([1, n], 1, 1);
tmpX(2 * i - 1) = xp(2 * i - 1);
tmpX(2 * i) = xp(2 * i);
out = tmpX;
