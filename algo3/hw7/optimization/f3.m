function out=f3(x,~)
out=x.^2+sin(2*x);

if nargin==1, mydraw(@f3,x,[-10 10]); end