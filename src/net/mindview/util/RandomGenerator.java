package net.mindview.util;

import java.util.Random;

public class RandomGenerator {
	private static Random r = new Random(47);
	public static class Boolean implements Generator<java.lang.Boolean>{
		@Override
		public java.lang.Boolean next() {
			// TODO Auto-generated method stub
			return r.nextBoolean();
		}
	}
	
	public static class Byte implements Generator<java.lang.Byte>{
		@Override
		public java.lang.Byte next() {
			// TODO Auto-generated method stub
			return (byte)r.nextInt();
		}
	}
	
	public static class Character implements Generator<java.lang.Character>{
		@Override
		public java.lang.Character next() {
			// TODO Auto-generated method stub
			return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
		}
	}
	
	public static class String extends CountingGenerator.String{
		{
			cg = new Character();
		}
		
		public String(){}
		public String(int length){
			super(length);
		}
	}
	
	public static class Integer implements Generator<java.lang.Integer>{
		private int mod = 10000;
		public Integer(){}
		public Integer(int mod){
			this.mod = mod;
		}
		@Override
		public java.lang.Integer next() {
			// TODO Auto-generated method stub
			return r.nextInt(mod);
		}
	}
	
	public static class Long implements Generator<java.lang.Long>{
		private int mod = 10000;
		public Long(){}
		public Long(int mod){
			this.mod = mod;
		}
		@Override
		public java.lang.Long next() {
			// TODO Auto-generated method stub
			return new java.lang.Long(r.nextInt(mod));
		}
	}
	
	public static class Float implements Generator<java.lang.Float>{
		@Override
		public java.lang.Float next() {
			// TODO Auto-generated method stub
			int trimmed = Math.round(r.nextFloat() * 100);
			return ((float)trimmed) / 100;
		}
	}
	
	public static class Double implements Generator<java.lang.Double>{
		@Override
		public java.lang.Double next() {
			// TODO Auto-generated method stub
			long trimmed = Math.round(r.nextDouble() * 100);
			return ((double)trimmed) / 100;
		}
	}
	
	
}
