function [I] = read_gray_image(im_path)
%read_image: This function reads image and convert it to gray scale.

    Io = imread(im_path);

    [m, n, d] = size(Io);
    if(d == 1)
        I = Io;
    else
        I = rgb2gray(Io);
    end
    figure
    imshow(I);
end