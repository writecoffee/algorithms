function [coeffs,pos]=readcoeffs(bits,pos,DCcode,ACcode)
% This function reads cosine transform coefficients from an array "bits",
% starting at position "pos".
% bits contains 0's and 1's, encoded according to the variable length
% encodings specified by DCcode, ACcode, and the specifics of the JPEG
% format.
% The output is a length-64 block of cosine transform coefficients "coeffs",
% along with the position "pos" where the next block starts.

coeffs=zeros(1,64);
