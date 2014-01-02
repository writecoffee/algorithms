function out=betterImageBasis()
% loads an image, and then produces a 256x256 image consisting of 256 16x16
% subimages that represent a principal components analysis of the best way 
% to represent 16x16 subimages of the loaded image.

%load an image!
im = mean(double(imread('hobbit.jpg')),3);

%construct a 256x10000 matrix storing 10000 random 16x16 blocks of im
M = zeros(256,10000);

% block length
L = 16;

rows = size(im,1);
cols = size(im,2);

for i = 1:10000
    
    % choose a random pix(x,y) as the starting point
    x = randi([1,rows-L+1]);
    y = randi([1,cols-L+1]);
    
    block = im(x : x+L-1, y : y+L-1);
    r_block = reshape(block, 256, 1);
    
    M(:,i) = r_block;
    
end
    
[u,~,~]=svd(M,'econ') ; %compute the "economy size" singular value decomposition of M

out = zeros(256,256);
column = 1;

for i = 1:16
    for j = 1:16
        block = reshape(u(:,column),L,L);
        out( (i-1)*L+1 : i*L, (j-1)*L+1 : j*L ) = block;
        column = column + 1;
    end
end


imagesc(out); colormap gray;