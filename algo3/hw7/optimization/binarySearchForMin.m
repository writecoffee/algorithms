function x=binarySearchForMin(func, L, U, eps)
mid = (L + U) / 2;
if abs(U - L) < eps
    x = mid;
elseif func(mid) <= func(mid + eps)
    x = binarySearchForMin(func, L, mid, eps);
else
    x = binarySearchForMin(func, mid, U, eps);
end

