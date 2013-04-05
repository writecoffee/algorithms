function [x,y]=gradientDescent2D(func,x,y,scale,eps)
gx = (func(x + eps, y) - func(x, y)) / eps;
gy = (func(x, y + eps) - func(x, y)) / eps;
updateX = x - scale * gx;
updateY = y - scale * gy;
if abs(updateX - x) < eps && abs((updateY - y)) < eps
    x = x;
    y = y;
else
    [x, y] = gradientDescent2D(func, updateX, updateY, scale, eps);
end
