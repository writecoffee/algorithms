function out=f4(x,~)
out=x.^2/10+sin(2*x);

if nargin==1, mydraw(@f4,x,[-10 10]); end