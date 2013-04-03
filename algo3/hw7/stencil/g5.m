function out=g5(x)
out=myfunc(x(1),x(2));

%drawing code:
xrange=[-10 10]; yrange=[-10 10];
figure(101);
dat=get(101,'UserData');
if isempty(dat) || now-dat.time>1/86400,
    dat.x=x(1); dat.y=x(2);
else
    dat.x=[dat.x;x(1)]; dat.y=[dat.y;x(2)];
end
xr=xrange(1)+diff(xrange)*(0:.01:1); yr=yrange(1)+diff(yrange)*(0:.01:1);
[x,y]=meshgrid(xr,yr);
imagesc(xr,yr,myfunc(x,y)); hold on;
plot(dat.x,dat.y,'r:p','LineWidth',2); hold off;
[m,i]=min(myfunc(dat.x,dat.y));
s=sprintf('%d function evaluations; best: f(%.3f,%.3f)=%.3g',length(dat.x),dat.x(i),dat.y(i),m);title(s);
drawnow
dat.time=now; set(101,'UserData',dat);pause(.001);

function out=myfunc(x,y) %the function to be evaluated
out=min(100,((6-x).^2+100*(y+5-x.^2/10).^2)/100);