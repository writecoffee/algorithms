function [f,A,b,Aeq,beq,LB,UB]=L1MaxRegression(x,y)
% Given vectors x, y that represent a series of points in the plane,
% returns parameters f, A, b, Aeq, beq, LB, UB, designed to be used as
% inputs to Matlab's linear programming routine, 
%   out = linprog(f,A,b,Aeq,beq,LB,UB)
% where the first two entries of the resulting vector "out" should
% represent the slope and intercept of the line that has minimal "max
% distance" from the input points.

n   = size(x, 2);

f   = [zeros(2, 1); 1];

% constraints for Zi (i from 1 to n), Zi >= 0
Az  = [0 0 -1];

Ac  = [x', ones(n, 1)];

% constraints for |pXi + q - Yi| <= Z
Ap  = [Ac, ones(n, 1) .* -1];

% constraints for |pXi + q - Yi| >= -Z
An  = [Ac .* -1, ones(n, 1) .* -1];

A   = [Ap; An; Az];

b   = [ones(n, 1) .* y'; ones(n, 1) .* y' .* -1; 0];

Aeq = [];
beq = [];
LB  = []; % this is how you make sure each variable is nonnegative, if this is what you want
UB  = [];
