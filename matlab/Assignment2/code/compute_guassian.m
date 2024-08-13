function [gxy] = compute_guassian(x,y,sigma)
%compute_guassian: This function computes guassian.

    gxy = (1 / (sigma * sqrt(2 * pi))) * exp(-0.5 * (x^2 + y^2) / sigma ^2);
end