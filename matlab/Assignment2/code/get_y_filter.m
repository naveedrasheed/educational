function [Hy maxy] = get_y_filter(sigma)
%get_y_filter: This function returns filter in y direction.

    d = get_guassian_dim(sigma);
    offset = floor(d/2);

    Hy = zeros(d);
    
    for x = -offset:offset
        for y = -offset:offset
            Hy(x+offset + 1,y+offset + 1) = -y/(sigma ^2) * compute_guassian(x,y,sigma);
        end
    end
    
    maxy = max(max(Hy));
    Hy = Hy / maxy;
    Hy = Hy * 255;    
    Hy = round(Hy);
end