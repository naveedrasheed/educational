% Local Feature Stencil Code
% CS 4495 / 6476: Computer Vision, Georgia Tech
% Written by James Hays

% This script 
% (1) Loads and resizes images
% (2) Finds interest points in those images                 (you code this)
% (3) Describes each interest point with a local feature    (you code this)
% (4) Finds matching features                               (you code this)
% (5) Visualizes the matches
% (6) Evaluates the matches based on ground truth correspondences

addpath('C:\Octave\Octave-4.0.0\share\octave\packages\image-2.4.1');
close all

% There are numerous other image sets in the supplementary data on the
% project web page. You can simply download images off the Internet, as
% well. However, the evaluation function at the bottom of this script will
% only work for three particular image pairs (unless you add ground truth
% annotations for other image pairs). It is suggested that you only work
% with the two Notre Dame images until you are satisfied with your
% implementation and ready to test on additional images. A single scale
% pipeline works fine for these two images (and will give you full credit
% for this project), but you will need local features at multiple scales to
% handle harder cases.
image1 = imread('../data/Notre Dame/921919841_a30df938f2_o.jpg');
image2 = imread('../data/Notre Dame/4191453057_c86028ce1f_o.jpg');
eval_file = '../data/Notre Dame/921919841_a30df938f2_o_to_4191453057_c86028ce1f_o.mat';

%This pair is relatively easy
% image1 = imread('../data/Mount Rushmore/9021235130_7c2acd9554_o.jpg');
% image2 = imread('../data/Mount Rushmore/9318872612_a255c874fb_o.jpg');
% eval_file = '../data/Mount Rushmore/9021235130_7c2acd9554_o_to_9318872612_a255c874fb_o.mat';

%This pair is relatively difficult
% image1 = imread('../data/Episcopal Gaudi/4386465943_8cf9776378_o.jpg');
% image2 = imread('../data/Episcopal Gaudi/3743214471_1b5bbfda98_o.jpg');
% eval_file = '../data/Episcopal Gaudi/4386465943_8cf9776378_o_to_3743214471_1b5bbfda98_o.mat';

%make images smaller to speed up the algorithm. This parameter gets passed
%into the evaluation code so don't resize the images except by changing
%this parameter.
scale_factor = 0.5;
image1 = imresize(image1, scale_factor, 'bilinear');
image2 = imresize(image2, scale_factor, 'bilinear');

image1 = single(image1)/255;
image2 = single(image2)/255;

%imshow(image1);

% You don't have to work with grayscale images. Matching with color
% information might be helpful.
image1_bw = rgb2gray(image1);
image2_bw = rgb2gray(image2);

feature_width = 16; %width and height of each local feature, in pixels. 

%% Find distinctive points in each image. Szeliski 4.1.1
% !!! You will need to implement get_interest_points. !!!
[x1, y1] = get_interest_points(image1_bw, feature_width);
[x2, y2] = get_interest_points(image2_bw, feature_width);

%% Create feature vectors at each interest point. Szeliski 4.1.2
% !!! You will need to implement get_features. !!!
[image1_features] = get_features(image1_bw, x1, y1, feature_width);
[image2_features] = get_features(image2_bw, x2, y2, feature_width);


%% Match features. Szeliski 4.1.3
% !!! You will need to implement get_features. !!!
[matches, confidences] = match_features(image1_features, image2_features);

% You might want to set 'num_pts_to_visualize' and 'num_pts_to_evaluate' to
% some constant (e.g. 100) once you start detecting hundreds of interest
% points, otherwise things might get too cluttered. You could also
% threshold based on confidence.

% There are two visualization functions. You can comment out one of both of
% them if you prefer.
num_pts_to_visualize = size(matches,1);
show_correspondence(image1, image2, x1(matches(1:num_pts_to_visualize,1)), ...
                                    y1(matches(1:num_pts_to_visualize,1)), ...
                                    x2(matches(1:num_pts_to_visualize,2)), ...
                                    y2(matches(1:num_pts_to_visualize,2)));
                                 
show_correspondence2(image1, image2, x1(matches(1:num_pts_to_visualize,1)), ...
                                     y1(matches(1:num_pts_to_visualize,1)), ...
                                     x2(matches(1:num_pts_to_visualize,2)), ...
                                     y2(matches(1:num_pts_to_visualize,2)));

% This evaluation function will only work for the particular Notre Dame
% image pair specified in the starter code.  Comment out this function if
% you are not testing on the Notre Dame, Mount Rushmore, or Episcopal Gaudi
% image pairs. Only those pairs have ground truth available. You can use
% collect_ground_truth_corr.m to build the ground truth for other image
% pairs if you want, but it's very tedious. It would be a great service to
% the class for future years, though!
num_pts_to_evaluate = size(matches,1);
evaluate_correspondence(image1, image2, eval_file, scale_factor, ... 
                        x1(matches(1:num_pts_to_evaluate,1)), ...
                        y1(matches(1:num_pts_to_evaluate,1)), ...
                        x2(matches(1:num_pts_to_evaluate,2)), ...
                        y2(matches(1:num_pts_to_evaluate,2)));












