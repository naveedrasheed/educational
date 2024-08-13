function [d] = get_guassian_dim(sigma)
%get_guassian_dim: This function returns the dimension of guassion
%function.

    x = sqrt(-2 * (sigma ^ 2) * log(0.3));
    d = 2 * round(x) + 1;
end