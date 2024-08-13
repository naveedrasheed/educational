----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    16:13:40 11/13/2009 
-- Design Name: 
-- Module Name:    if_stage123 - Behavioral 
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

entity if_stage123 is
Port ( clock : in  STD_LOGIC;
           rst : in  STD_LOGIC;
			  output : out STD_LOGIC_VECTOR (31 downto 0));
end if_stage123;

architecture Behavioral of if_stage123 is
component I_F is
    Port (
	 datain : in std_logic_vector(31 downto 0 );
			  dataout : out  STD_LOGIC_VECTOR (31 downto 0)
			  --out1 : out  STD_LOGIC_VECTOR (7 downto 0)
           );
end component;

component I_M is
    Port ( data_in : in  STD_LOGIC_VECTOR (31 downto 0); 
	        address: in std_logic_vector(7 downto 0);
	        clock : in  STD_LOGIC;
           reset : in  STD_LOGIC;
           enable : in  STD_LOGIC;
           read : in  STD_LOGIC;
           write : in  STD_LOGIC; 
          data_out : out  STD_LOGIC_VECTOR (31 downto 0));
end component;

signal tmp : std_logic_vector(31 downto 0);
tmp<=datain;
begin
process(rst,clock)
begin

if (rst='1') then 
output<="00000000000000000000000000000000";
else if(clock='1' and clock'event) then 
tmp<=output;end if ;
end if ;
end process;

end Behavioral;

