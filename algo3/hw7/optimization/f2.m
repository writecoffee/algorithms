function out=f2(x,~)
out=abs(x-pi);

if nargin==1, mydraw(@f2,x,[-10 10]); end