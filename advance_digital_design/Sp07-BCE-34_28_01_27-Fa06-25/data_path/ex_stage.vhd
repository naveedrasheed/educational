----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    12:00:47 01/12/2010 
-- Design Name: 
-- Module Name:    ex_stage - Behavioral 
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

entity ex_stage is
    Port ( a : in  STD_LOGIC_VECTOR (31 downto 0);
           b : in  STD_LOGIC_VECTOR (31 downto 0);
           c : in  STD_LOGIC_VECTOR (31 downto 0);
			  alu_op: in STD_LOGIC_VECTOR (5 downto 0);
			  alu_src: in STD_LOGIC_VECTOR (1 downto 0);
           alu_out : out  STD_LOGIC_VECTOR (31 downto 0);
           reg_out : out  STD_LOGIC_VECTOR (31 downto 0));
end ex_stage;

architecture Behavioral of ex_stage is

component alu_nvd is
generic(width:natural:=32);
    Port ( 
			op : in  STD_LOGIC_VECTOR (1 downto 0);
           a : in  STD_LOGIC_VECTOR (width-1 downto 0);
           b : in  STD_LOGIC_VECTOR (width-1 downto 0);
           output : out  STD_LOGIC_VECTOR (width-1 downto 0));

end component;

signal alu_b:STD_LOGIC_VECTOR (31 downto 0);
begin

alu_b<= b when alu_op ="000000" else
		c;
aluu: alu_nvd generic map(32)port map(alu_src,a,alu_b,alu_out);
reg_out<=b;

end Behavioral;

