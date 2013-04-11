function out=denoiseQuadratic(inp, k)
% Given an input image inp, and a scaling factor k, returns the optimal
% quadratic denoising of the image, as specified in the handout

fXorig = fft2(inp);
kernel1 = [1, -1];
kernel2 = [1; -1];

fK1_sqr = abs(fft2(kernel1, size(inp, 1), size(inp, 2))).^2;
fK2_sqr = abs(fft2(kernel2, size(inp, 1), size(inp, 2))).^2;

xPrime = real(ifft2(fXorig ./ (k * (fK1_sqr + fK2_sqr) + 1)));

figure;
imshow(uint8(xPrime), []);

out = xPrime;
