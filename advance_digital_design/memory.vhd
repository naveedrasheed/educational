----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    17:15:34 11/06/2009 
-- Design Name: 
-- Module Name:    memory - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

---- Uncomment the following library declaration if instantiating
---- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity memory is
    Port ( addr : in  STD_LOGIC_VECTOR (7 downto 0);
           data_in : in  STD_LOGIC_VECTOR (31 downto 0);
           dre : in  STD_LOGIC;
           dwe : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           data_out : out  STD_LOGIC_VECTOR (31 downto 0));
end memory;

architecture Behavioral of memory is

type ram_type is array (0 to 255) of STD_LOGIC_VECTOR (31 downto 0);
signal tmp_ram:ram_type;

begin

write:process(clk,rst)
begin
	if(rst='1')then
		for i in 0 to 255 loop
				tmp_ram(i)<="00000000000000000000000000000000";
		end loop;
	else if(clk='1' and clk'event)then
		if(dre='0' and dwe='1')then
			tmp_ram(conv_integer(addr))<=data_in;
		end if;
	end if;
	end if;
end process;
			
read:process(clk,rst)
begin
	 if(clk='1' and clk'event)then
			if(dre='1' and dwe='0')then
				data_out<=tmp_ram(conv_integer(addr));
			end if;
	end if;
end process;

end Behavioral;