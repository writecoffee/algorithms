function br=chasm(x,draw)
% Bilbo is trying to get across a chasm by building a bridge supported at
% its left end. The input x, which should be a vector of 100 elements,
% describes the thickness of the bridge at each point, which must be
% between 0.2 and 20. Bilbo slowly extends the bridge over the chasm, and
% the return value "br" returns (negative) the maximum length of the bridge 
% before it breaks. Explicitly, this code first checks whether the bridge 
% consisting of just x(100) can support its own weight; if it can, then Bilbo 
% extends the bridge one unit and the code checks if the bridge consisting of
% x(99:100) can support its own weight, etc., with the algorithm returning
% the number of times the bridge was extended before it broke, or 100 if it
% successfully bridged the chasm without breaking.
%
% If you are curious, bridge physics works as follows: the strain induced
% on a bridge segment i of thickness x(i) by having to hold up a second 
% bridge segment j with mass x(j) that is distance (j-i) to the right is
% x(j)*(j-i)/x(i). These expressions are summed for all segments to the
% right of i, and if the strain is greater than 300, the bridge breaks at i.

if numel(x)~=100, error('Input must have 100 elements'); end
x=min(20,max(.2,x(:)))'; %enforce thickness constraints, and make x a row vector
x=x(end:-1:1); %flip x
cm=cumsum(x); %cumulative mass
cxm=cumsum(x.*(1:100)); %cumulative sum of position times mass
strain=(cm.*(1:100)-cxm)./x; %compute strain
br=find(strain>300,1,'first')-1; %the bridge breaks if the strain at a point is bigger than 300
if isempty(br), br=100; end
br=-br; %flip the sign so we can minimize the output
if nargin==2, %graphics code
    map=colormap('hot');figure(100);clf;for i=1:100,c=map(ceil(max(.2,.8-strain(i)/300*.6)*64),:);h=rectangle('Position',[-br-i,0,1,x(i)]','EdgeColor',c,'FaceColor',c);end;
    rectangle('Position',[-100 -100 100 100],'FaceColor',[0 0 0]);rectangle('Position',[100 -100 100 100],'FaceColor',[0 0 0]);dr=imread('dragon.png');hold on;image([50 90],[-58 -98],dr);hold off;axis image;axis([-100 130 -99 30]);
end
