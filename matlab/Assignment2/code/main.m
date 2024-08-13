close all
clear all

image_path = 'test_images';
result_path = 'results';

image_name = 'circleBlured.png';
test_my_canny(image_path,image_name,result_path);

image_name = 'Fig0107(a)(chest-xray-vandy).tif';
test_my_canny(image_path,image_name,result_path);

image_name = 'Fig0107(c)(headCT-Vandy).tif';
test_my_canny(image_path,image_name,result_path);

image_name = 'mecca06.jpg';
test_my_canny(image_path,image_name,result_path);

image_name = 'shapessm.jpg';
test_my_canny(image_path,image_name,result_path);

close all