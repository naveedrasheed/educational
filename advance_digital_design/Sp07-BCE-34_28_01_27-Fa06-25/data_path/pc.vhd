----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:21:39 10/05/2009 
-- Design Name: 
-- Module Name:    register - Behavioral 
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

entity pc is
generic (n:natural:=8);
    Port ( I : in  STD_LOGIC_VECTOR (n-1 downto 0);
           clock : in  STD_LOGIC;
           load : in  STD_LOGIC;
           clear : in  STD_LOGIC;
           Q : out  STD_LOGIC_VECTOR (n-1 downto 0));
end pc;

architecture Behavioral of pc is
signal Q_tmp: std_logic_vector(n-1 downto 0);
begin
process(I,clock,load,clear)
	begin
		if clear='1' then
		Q_tmp<=(Q_tmp'range=>'0');
		elsif(clock='1' and clock'event) then
			if(load='1') then
				Q_tmp<=I;
			end if;
		end if;
	end process;
Q<=Q_tmp;

end Behavioral;

