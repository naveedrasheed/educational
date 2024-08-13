function [Hx maxx] = get_x_filter(sigma)
%get_x_filter: This function returns filter in x direction.

    d = get_guassian_dim(sigma);
    offset = floor(d/2);

    Hx = zeros(d);
    
    for x = -offset:offset
        for y = -offset:offset
            Hx(x+offset + 1,y+offset + 1) = -x/(sigma ^2) * compute_guassian(x,y,sigma);
        end
    end
    
    maxx = max(max(Hx));
    Hx = Hx / maxx;
    Hx = Hx * 255;
    Hx = round(Hx);
end