function out=findGroupByRandomWalk(fr)
% This function takes as input a friendship random walk matrix, as output
% by randomFriendWalk(), and produces a plot, based on random walks in the
% friendship graph, that shows which people belong to the group of person
% 1.

p = zeros(3000,1);
p(1,1) = 1;

p1 = fr*p;
p2 = fr*p1;
p3 = fr*p2;
p4 = fr*p3;
p5 = fr*p4;
p6 = fr*p5;
p7 = fr*p6;
p8 = fr*p7;
p9 = fr*p8;
p10 = fr*p9;

%hold on;
%plot(p5);
%p2 =  plot(p10);
%set(p2, 'Color', 'red');
%out = p10;
plot(p5-p10); 
