----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    13:08:42 11/02/2009 
-- Design Name: 
-- Module Name:    alu_nvd - Behavioral 
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

entity alu_nvd is
generic(width:natural:=32);
    Port ( 
			op : in  STD_LOGIC_VECTOR (1 downto 0);
           a : in  STD_LOGIC_VECTOR (width-1 downto 0);
           b : in  STD_LOGIC_VECTOR (width-1 downto 0);
           output : out  STD_LOGIC_VECTOR (width-1 downto 0));
--           negetive : out  STD_LOGIC;
--           overflow : out  STD_LOGIC);
--           zero : out  STD_LOGIC);

end alu_nvd;

architecture Behavioral of alu_nvd is

component g_adder is

generic(width:natural);

    Port ( 
	 a : in  STD_LOGIC_VECTOR (width-1 downto 0);
           b : in  STD_LOGIC_VECTOR (width-1 downto 0);
			  cin : in  STD_LOGIC;
           sum : out  STD_LOGIC_VECTOR (width-1 downto 0);
           carry : out  STD_LOGIC);
end component;

signal add,sub:std_logic_vector(width-1 downto 0);

begin
--
ad:g_adder generic map(width) port map (a,b,'0',add,open);
su:g_adder generic map(width) port map (a,not b,'1',sub,open);

output<= add when op="00" else
			sub when op="01" else
			a nand b when op="10" else
			a nor b when op="11";
--
end Behavioral;

