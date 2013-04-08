% Empty file! Put whatever you want here
function out=bridgeRunner(sz)
output = zeros(1, sz);
input = zeros(1, sz);
input(sz) = 0.2;
output(sz) = 0.2;

for i = 1 : sz - 1
    arrayB = fliplr([1:i]);
    output(sz - i) = sum(output(sz-i+1:sz) .* arrayB ./ 300);
    output(sz - i) = ceil(output(sz - i) * 100) / 100;

    if output(sz - i) < 0.20
        output(sz - i) = 0.20;
    elseif output(sz - i) > 20
        output(sz - i) = 20;
    end

end
out = output;
