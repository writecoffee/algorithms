function mydraw2D(func,inpx,inpy,xrange,yrange)
figure(101);
dat=get(101,'UserData');
if isempty(dat) || now-dat.time>1/86400,
    dat.x=inpx(:); dat.y=inpy(:);
else
    dat.x=[dat.x;inpx(:)]; dat.y=[dat.y;inpy(:)];
end
xr=xrange(1)+diff(xrange)*(0:.01:1); yr=yrange(1)+diff(yrange)*(0:.01:1);
[x,y]=meshgrid(xr,yr);
imagesc(xr,yr,func(x,y,0)); hold on; %colorbar;
plot(dat.x,dat.y,'r:p','LineWidth',2); hold off;
title([num2str(length(dat.x)) ' function evaluations'])
drawnow
dat.time=now; set(101,'UserData',dat);pause(.001);
    