classdef hysteresis_threshold < handle   
    properties
        Ih
    end    
    methods
        function perform_hysteresis_threshold(ht_obj, Inms, i, j, Tl)
            %perform_hysteresis_threshold: This function perform hysteresis threshold recursively.
            
            if(ht_obj.Ih(i-1,j-1) == 0 && Inms(i-1,j-1) >= Tl)
                ht_obj.Ih(i-1,j-1) = Inms(i-1,j-1);
                ht_obj.perform_hysteresis_threshold(Inms, i-1, j-1, Tl);
            end
            
            if(ht_obj.Ih(i-1,j) == 0 && Inms(i-1,j) >= Tl)
                ht_obj.Ih(i-1,j) = Inms(i-1,j);
                ht_obj.perform_hysteresis_threshold(Inms, i-1, j, Tl);
            end
            
            if(ht_obj.Ih(i-1,j+1) == 0 && Inms(i-1,j+1) >= Tl)
                ht_obj.Ih(i-1,j+1) = Inms(i-1,j+1);
                ht_obj.perform_hysteresis_threshold(Inms, i-1, j+1, Tl);
            end
            
            if(ht_obj.Ih(i,j-1) == 0 && Inms(i,j-1) >= Tl)
                ht_obj.Ih(i,j-1) = Inms(i,j-1);
                ht_obj.perform_hysteresis_threshold(Inms, i, j-1, Tl);
            end
            
            if(ht_obj.Ih(i,j+1) == 0 && Inms(i,j+1) >= Tl)
                ht_obj.Ih(i,j+1) = Inms(i,j+1);
                ht_obj.perform_hysteresis_threshold(Inms, i, j+1, Tl);
            end
            
            if(ht_obj.Ih(i+1,j-1) == 0 && Inms(i+1,j-1) >= Tl)
                ht_obj.Ih(i+1,j-1) = Inms(i+1,j-1);
                ht_obj.perform_hysteresis_threshold(Inms, i+1, j-1, Tl);
            end
            
            if(ht_obj.Ih(i+1,j) == 0 && Inms(i+1,j) >= Tl)
                ht_obj.Ih(i+1,j) = Inms(i+1,j);
                ht_obj.perform_hysteresis_threshold(Inms, i+1, j, Tl);
            end
            
            if(ht_obj.Ih(i+1,j+1) == 0 && Inms(i+1,j+1) >= Tl)
                ht_obj.Ih(i+1,j+1) = Inms(i+1,j+1);
                ht_obj.perform_hysteresis_threshold(Inms, i+1, j+1, Tl);
            end
        end
    end    
end