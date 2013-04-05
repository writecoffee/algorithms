function x=gradientDescent(func, x, scale, eps)
g = (func(x + eps) - func(x)) / eps;
update = x - scale * g;
if abs(func(x + eps) - func(x)) < eps
    x = x;
else
    x = gradientDescent(func, update, scale, eps);
end
