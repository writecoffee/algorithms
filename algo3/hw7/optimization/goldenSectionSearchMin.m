function x=goldenSectionSearchMin(func, L, U, eps)
if U - L < eps
    x = L;
else
    phi = (sqrt(5) + 1) / 2;
    x1 = L;
    x3 = U;
    x2 = x3 - (x3 - x1) / phi;
    x4 = x1 + x3 - x2;

    if func(x4) > func(x2)
        x = goldenSectionSearchMin(func, x1, x4, eps);
    else
        x = goldenSectionSearchMin(func, x2, x3, eps);
    end
end

