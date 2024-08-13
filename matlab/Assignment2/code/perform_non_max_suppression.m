function [Inms Iq] = perform_non_max_suppression(Ig, Ia)
%perform_non_max_suppression: This function performs non max suppression.

dim = size(Ig);
t = 10;
for i = 1:dim(1)
    for j = 1:dim(2)
        if(Ig(i,j) <= t)
            Ia(i,j) = 0;% -1
        else
            if((Ia(i,j) >= 0 && Ia(i,j) <= 22.5) || (Ia(i,j) >= 337.5 && Ia(i,j) < 360))
                Ia(i,j) = 0;
                
            elseif((Ia(i,j) >= 22.5 && Ia(i,j) <= 67.5))
                Ia(i,j) = 45;
                
            elseif((Ia(i,j) >= 67.5 && Ia(i,j) <= 112.5))
                Ia(i,j) = 90;
                
            elseif((Ia(i,j) >= 112.5 && Ia(i,j) <= 157.5))
                Ia(i,j) = 135;

            elseif((Ia(i,j) >= 157.5 && Ia(i,j) < 202.5))
                Ia(i,j) = 180;

            elseif((Ia(i,j) >= 202.5 && Ia(i,j) < 247.5))
                Ia(i,j) = 225;

            elseif((Ia(i,j) >= 247.5 && Ia(i,j) < 292.5))
                Ia(i,j) = 270;

            elseif((Ia(i,j) >= 292.5 && Ia(i,j) < 337.5))
                Ia(i,j) = 315;
            end
        end
    end
end

Iq = Ia;
Inms = zeros(dim);

for i = 2:dim(1)-1
    for j = 2:dim(2)-1
        if(Ia(i,j) == 180 || Ia(i,j) == 0)
            if(max([Ig(i,j-1) Ig(i,j) Ig(i,j+1)]) == Ig(i,j))
               Inms(i,j) = Ig(i,j);
            end        
        elseif(Ia(i,j) == 45 || Ia(i,j) == 225)
            if(max([Ig(i-1,j+1) Ig(i,j) Ig(i+1,j-1)]) == Ig(i,j))
               Inms(i,j) = Ig(i,j);
            end  
        elseif(Ia(i,j) == 90|| Ia(i,j) == 270)
            if(max([Ig(i-1,j) Ig(i,j) Ig(i+1,j)]) == Ig(i,j))
               Inms(i,j) = Ig(i,j);
            end  
        elseif(Ia(i,j) == 135|| Ia(i,j) == 315)
            if(max([Ig(i-1,j-1) Ig(i,j) Ig(i+1,j+1)]) == Ig(i,j))
               Inms(i,j) = Ig(i,j);
            end  
        end
    end
end
end