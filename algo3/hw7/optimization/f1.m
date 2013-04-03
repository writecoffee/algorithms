function out=f1(x,~)
out=3*abs(x-1).^1.5;

if nargin==1, mydraw(@f1,x,[-10 10]); end