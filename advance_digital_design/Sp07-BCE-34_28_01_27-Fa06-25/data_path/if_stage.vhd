----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:10:34 01/12/2010 
-- Design Name: 
-- Module Name:    if_stage - Behavioral 
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

entity if_stage is
    Port ( 
				addr : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_in : in  STD_LOGIC_VECTOR (31 downto 0);
           mre : in  STD_LOGIC;
           mwe : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
			  pce: in  STD_LOGIC;
			  
				pc_p_4 : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_out : out  STD_LOGIC_VECTOR (31 downto 0);
           nxt_pc : out  STD_LOGIC_VECTOR (7 downto 0));
end if_stage;

architecture Behavioral of if_stage is

component pc is
generic (n:natural:=8);
    Port ( I : in  STD_LOGIC_VECTOR (n-1 downto 0);
           clock : in  STD_LOGIC;
           load : in  STD_LOGIC;
           clear : in  STD_LOGIC;
           Q : out  STD_LOGIC_VECTOR (n-1 downto 0));
end component;

component inst_memory is
generic(width :natural :=32);
    Port ( addr : in  STD_LOGIC_VECTOR (7 downto 0);
           inst_in : in  STD_LOGIC_VECTOR (width-1 downto 0);
           mre : in  STD_LOGIC;
           mwe : in  STD_LOGIC;
           clk : in  STD_LOGIC;
           rst : in  STD_LOGIC;
           inst_out : out  STD_LOGIC_VECTOR (width-1 downto 0));
end component;

signal pc_out:STD_LOGIC_VECTOR (7 downto 0);

begin

pcc: pc generic map(8)port map(pc_p_4,clk,pce,rst,pc_out);

mem: inst_memory generic map(32)port map(pc_out,inst_in,mre,mwe,clk,rst,inst_out);
nxt_pc<=pc_out+4;

end Behavioral;

