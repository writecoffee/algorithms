function [rating]=bilbwop(plan,draw)
%see the explanation in the handout
if numel(plan)~=40, error('Input must have 40 entries'); end
plan=[[.5;0] reshape(plan,2,20)];
plan=min(1,max(-1,plan));
dt=.1; friction=1; gravity=.1;
mass=[30 10 5 10 5 10]; %mass of each joint
edge=[1 2;2 3;1 4;4 5;1 6]; angles=[5 1;5 3;1 2;3 4];
edgel=[.5 .5 .5 .5 .9]; edgesp=[160 180 160 180 160]; edgef=[8 8 8 8 8];
anglessp=[10 10 5 5]*2; anglesf=[8 8 4 4];
f=zeros(2,6); v=zeros(2,6); p=[0 0 -.5 .5 .5 .3;2 1 0 1 0 3.8]/2;
for i=dt/2:dt:20,
    t=plan(:,floor(i)+1)*(1+floor(i)-i)+plan(:,ceil(i)+1)*(i-floor(i));
    contact=(p(2,:)<=0); p(2,contact)=0; %contact with the ground
    anglesl=-[2.8+t(1) 2.8-t(1) (1-t(2))*.9 (1+t(2))*.9];
    disp=p(:,edge(:,2))-p(:,edge(:,1)); dist=sqrt(sum(disp.^2)); dispn=bsxfun(@rdivide,disp,dist);
    dispv=v(:,edge(:,2))-v(:,edge(:,1)); distv=2*sum(disp.*dispv);
    forceedge=bsxfun(@times,(edgel-dist).*edgesp-distv.*edgef,dispn);
    edgeang=atan2(disp(2,:),disp(1,:)); edgeangv=(dispv(1,:).*disp(2,:)-dispv(2,:).*disp(1,:))./dist.^2;
    angv=edgeangv(angles(:,2))-edgeangv(angles(:,1));
    angf=(mod(edgeang(angles(:,2))-edgeang(angles(:,1))-anglesl+pi,2*pi)-pi).*anglessp-angv.*anglesf;
    edgetorque=cat(1,-disp(2,:)./dist.^2,disp(1,:)./dist.^2);
    alledgeforces=cat(2,bsxfun(@times,angf,edgetorque(:,angles(:,1))),-bsxfun(@times,angf,edgetorque(:,angles(:,2))));
    forceedge=forceedge+sparse(repmat(cat(1,1,2),1,8),repmat(reshape(angles,1,[]),2,1),alledgeforces);
    f=f*0; for j=1:5, f(:,edge(j,1))=f(:,edge(j,1))-forceedge(:,j); f(:,edge(j,2))=f(:,edge(j,2))+forceedge(:,j); end
    f(2,:)=f(2,:)-gravity*mass;
    v=v+bsxfun(@rdivide,f*dt,mass); 
    fric=-min(v(2,:),0).*contact; v(2,contact)=max(0,v(2,contact));
    v(1,:)=sign(v(1,:)).*max(0,abs(v(1,:))-fric*friction);
    p=p+v*dt;
    if nargin==2, %drawing code
        figure(100);plot(p(1,[6 1 2 3 2 1 4 5]),p(2,[6 1 2 3 2 1 4 5]),'k',[-2,100],[0,0],'r',p(1,6),p(2,6),'ko','MarkerSize',10,'MarkerFaceColor','k');
        axis equal;axis([max(4,p(1,1))+[-6 3] -1 6]);
    end;
    if any(contact([1 6])), break; end %hip or head hit the ground, so stop
end
rating=-p(1,1); %return (negative) x coordinate of hip
%v is the velocity of each part of Bilbo; the first entry is the hip, 6th
%is the head; entries 2 through 5 are knees and feet