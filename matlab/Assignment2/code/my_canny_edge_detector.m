function [Ie Ix Iy Ig Iq] = my_canny_edge_detector(I, sigma, Th, Tl)
%my_canny_edge_detector: This function implements canny edge detector.

[Hx maxx] = get_x_filter(sigma);
Ix = conv2(double(I),Hx);

[Hy maxy] = get_y_filter(sigma);
Iy = conv2(double(I),Hy);

Ig = sqrt(Ix.*Ix + Iy.*Iy);
Ia = atan2d(Iy,Ix) + 180;

[Inms Iq] = perform_non_max_suppression(Ig, Ia);

dim = size(Ig);
ht = hysteresis_threshold;
ht.Ih = zeros(dim);

maxx = max(max(Inms));
Inms = Inms / maxx * 255;

for i = 2:dim(1)-1
    for j = 2:dim(2)-1
        if(ht.Ih(i,j) == 0 && Inms(i,j) >= Th)
            ht.Ih(i,j) = Inms(i,j);
            ht.perform_hysteresis_threshold(Inms, i, j, Tl);
            imshow(ht.Ih);
        end
    end
end

s = size(Hx)/2;
offset = floor(s(1));

Ie = ht.Ih(offset+1:dim(1)-offset,offset+1:dim(2)-offset);
Ie = uint8(mat2gray(Ie) * 255);
end