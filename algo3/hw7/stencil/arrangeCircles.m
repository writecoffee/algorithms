function rating=arrangeCircles(pos,draw)
% Given circles of radii 1, 2, 3, ... 10, you want to arrange them in the
% plane so that a) they do not overlap, and b) they are contained in the
% smallest possible square (with sides parallel to the axes). The return
% value "rating" is the side length of this square, or 1000 if the circles
% overlap. The input, "pos", consists of 20 numbers, interpreted as the x
% and y positions of the center of the circle of radius 1, followed by the
% x and y positions of the center of the circle of radius 2, etc.

if numel(pos)~=20, error('Input must have 20 numbers'); end
pos=reshape(pos,2,10); %make pos a 2 by 10 matrix
width=max(pos(1,:)+(1:10))-min(pos(1,:)-(1:10));
height=max(pos(2,:)+(1:10))-min(pos(2,:)-(1:10));
rating=max(width,height);
dists=sqrt(bsxfun(@minus,pos(1,:),pos(1,:)').^2+bsxfun(@minus,pos(2,:),pos(2,:)').^2); %compute all distance pairs
dists=dists+1000*eye(10); %add 1000 to the diagonal, so that circles are not penalized for intersecting themselves
viol=(dists-bsxfun(@plus,1:10,(1:10)'))<0;
if nargin==2, %graphics code follows
    figure(100); clf
    th=(0:50)/50*2*pi; si=sin(th); co=cos(th);
    hold on
    for i=1:10,
        plot(si*i+pos(1,i),co*i+pos(2,i));
    end
    rectangle('Position',[(max(pos(1,:)+(1:10))+min(pos(1,:)-(1:10))-rating)/2 (max(pos(2,:)+(1:10))+min(pos(2,:)-(1:10))-rating)/2 rating rating]);
    axis equal;
    hold off;
end
if any(viol(:)), rating=1000; end %penalty if any circles overlap