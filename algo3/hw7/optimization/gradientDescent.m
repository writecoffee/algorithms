function x=gradientDescent(func, x, scale, eps)
g = (func(x + eps) - func(x)) / eps;
update = x - scale * g;
if abs(x - update) < eps
    x = x;
else
    x = gradientDescent(func, x - scale * g, scale, eps)
end
