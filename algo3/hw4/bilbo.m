function im=bilbo(file)
% This function takes as input a filename storing the JPEG image of Bilbo
% the hobbit, and returns the same thing as im=imread(file) does, though
% decoding the file ourselves. This function is only guaranteed to work on
% the official hobbit image.

fid = fopen(file,'r');
fseek(fid,86,-1);q1=fread(fid,64,'uint8');
fseek(fid,154,-1);q2=fread(fid,64,'uint8');
fseek(fid,243,-1);hs1=fread(fid,16,'uint8');h1=fread(fid,sum(hs1),'uint8');
fseek(fid,276,-1);hs2=fread(fid,16,'uint8');h2=fread(fid,sum(hs2),'uint8');
fseek(fid,459,-1);hs3=fread(fid,16,'uint8');h3=fread(fid,sum(hs3),'uint8');
fseek(fid,492,-1);hs4=fread(fid,16,'uint8');h4=fread(fid,sum(hs4),'uint8');
fseek(fid,684,-1);bits=fread(fid,'uint8');
bits=bits(logical([1;(bits(1:end-3)~=255)]));bits=(dec2bin(bits,8)-48)';
fclose(fid);
zz=[1  2  6  7  15 16 28 29;...
    3  5  8  14 17 27 30 43;...
    4  9  13 18 26 31 42 44;...
    10 12 19 25 32 41 45 54;...
    11 20 24 33 40 46 53 55;...
    21 23 34 39 47 52 56 61;...
    22 35 38 48 51 57 60 62;...
    36 37 49 50 58 59 63 64]; %% zigzag indexing table

t1=createVLC(hs1,h1);  %% needs to be implemented!!
t2=createVLC(hs2,h2);
t3=createVLC(hs3,h3);
t4=createVLC(hs4,h4);

%%keyboard %% pauses code here in debug mode; remove this in your final submission

im=zeros(400,672); prev=128; pos=1; %initializes an empty image

% SUGGESTION: precompute the 8x8 cosine transform matrix M here
n=8;M=[]; for j=0:n-1, M=[M;cos((.5:n)/n*pi*j)]; end
for yblock=0:24 %% loop over 16x16 blocks in the image, in the vertical direction
    for xblock=0:41 %% loop over 16x16 blocks in the image, in the horizontal direction
        for y=0:1 %% loop over 8x8 subblocks in each 16x16 block
            for x=0:1 %% loop over 8x8 subblocks in each 16x16 block
                [coeffs,pos]=readcoeffs(bits,pos,t1,t2);
                [coeffs,prev]=fixJPEGcoeffs(coeffs(zz),q1(zz),prev); %% needs to be implemented!!
% block = coeffs; %% CHANGE THIS TO THE 2-DIMENSIONAL COSINE TRANFORM OF COEFFS!!
                block=((coeffs*M)'*M)';
                im(yblock*16+y*8+(1:8),xblock*16+x*8+(1:8))= block;
            end
        end
        for i=1:2, %% read color information and discard the data, updating pos
            [junk,pos]=readcoeffs(bits,pos,t3,t4); 
        end
    end
end

im=round(min(255,max(0,im(1:398,1:660)))); %% this is the final output

imA=double(imread('hobbit.jpg'));imA=imA(:,:,1)*.299+imA(:,:,2)*.587+imA(:,:,3)*.114;
figure(100); imagesc(im); axis image; colormap gray; colorbar; 
title(sprintf('Bilbo (your decoding), average error: %g',mean(abs(im(:)-imA(:)))));
figure(101); imagesc(imA); axis image; colormap gray; colorbar; title('Bilbo (reference decoding)');
set(100,'Position',[100 10 600 300]); set(101,'Position',[100 400 600 300]);
