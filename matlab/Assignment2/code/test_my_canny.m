function test_my_canny(image_path, image_name, result_path)
%test_my_canny: This function test canny edge detection.

    fname = fullfile(image_path,image_name);
    I = read_gray_image(fname);
    
    sigma_arr = [0.5 1 2];

    for i=1:3
        for Th=50:20:70
            
            sigma = sigma_arr(i);
            Tl = 30;

            [Ie Ix Iy Ig Iq] = my_canny_edge_detector(I, sigma, Th, Tl);

            rname = fullfile(result_path,strcat('sigma_',num2str(sigma),'_gx_', image_name));
            imwrite(Ix, rname);

            rname = fullfile(result_path,strcat('sigma_',num2str(sigma),'_gy_', image_name));
            imwrite(Iy, rname);

            rname = fullfile(result_path,strcat('sigma_',num2str(sigma),'_M_', image_name));
            imwrite(Ig, rname);

            rname = fullfile(result_path,strcat('sigma_',num2str(sigma),'_Angle_', image_name));
            imwrite(Iq, rname);

            rname = fullfile(result_path,strcat('sigma_',num2str(sigma),'hysteresis_Th=',num2str(Th),'_Tl=',num2str(Tl),'_', image_name));
            imwrite(Ie, rname);
        end
    end
end