function mydraw(func,inp,xrange)
figure(100);
dat=get(100,'UserData');
if isempty(dat) || now-dat.time>1/86400, dat.x=inp(:); else dat.x=[dat.x;inp(:)]; end
x=xrange(1)+diff(xrange)*(0:.001:1);
plot(x,func(x,0),'b');hold on,plot(dat.x,func(dat.x,0),'r:p','LineWidth',2); hold off;
title([num2str(length(dat.x)) ' function evaluations'])
drawnow
dat.time=now; set(100,'UserData',dat);pause(.001);
    