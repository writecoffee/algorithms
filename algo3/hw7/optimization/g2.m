function out=g2(x,y,~)
out=.01*(x-4).^2+.2*(y-1).^2;

if nargin==2, mydraw2D(@g2,x,y,[-10 10],[-10 10]); end