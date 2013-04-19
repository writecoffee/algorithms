function []=lineDrawer()

x = 1:10;
y = x + randn(1, 10);
y(1) = y(1)*1000;

f1 = @L1Regression;
f2 = @L1MaxRegression;

scatter(x, y, 25, 'b', '*');
lsline

[f,A,b,Aeq,beq,LB,UB] = f1(x,y);
result = linprog(f,A,b,Aeq,beq,LB,UB);
p = result(1);
q = result(2);
hline = refline([p q]);
set(hline, 'Color', 'r');

[f,A,b,Aeq,beq,LB,UB] = f2(x,y);
result = linprog(f,A,b,Aeq,beq,LB,UB);
p = result(1);
q = result(2);
hline = refline([p q]);
set(hline, 'Color', 'g');

