function [f,A,b,Aeq,beq,LB,UB]=L1Regression(x,y)
% Given vectors x, y that represent a series of points in the plane,
% returns parameters f, A, b, Aeq, beq, LB, UB, designed to be used as
% inputs to Matlab's linear programming routine, 
%   out = linprog(f,A,b,Aeq,beq,LB,UB)
% where the first two entries of the resulting vector "out" should
% represent the slope and intercept of the line that has minimal total
% distance from the input points.

f= ??? % needs to be filled in!
A=[];
b=[];
Aeq=[];
beq=[];
LB=zeros(size(f)); % this is how you make sure each variable is nonnegative, if this is what you want
UB=[];