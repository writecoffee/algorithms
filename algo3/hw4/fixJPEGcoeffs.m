function [coeffs,prev]=fixJPEGcoeffs(coeffs,q,prev)
% This code manipulates the cosine transform coefficients (coeffs) of each 
% 8x8 block in accordance with the JPEG specification. The quantization
% coefficients are input in q; the input prev should store the (1,1) cosine
% transform coefficient of the previous block; prev should output the (1,1)
% cosine transform coefficient of the current block

coeffs=coeffs.*q./4;
coeffs(1,:)=coeffs(1,:)./(2^.5);
coeffs(:,1)=coeffs(:,1)./(2^.5);
coeffs(1,1)=coeffs(1,1)+prev;
prev=coeffs(1,1);

end
