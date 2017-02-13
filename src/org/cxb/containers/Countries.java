package org.cxb.containers;

//: net/mindview/util/Countries.java
// "Flyweight" Maps and Lists of sample data.
import java.util.*;

public class Countries {
	public static final String[][] DATA = {
			// Africa
			{ "ALGERIA", "Algiers" }, { "ANGOLA", "Luanda" }, { "BENIN", "Porto-Novo" }, { "BOTSWANA", "Gaberone" },
			{ "BURKINA FASO", "Ouagadougou" }, { "BURUNDI", "Bujumbura" }, { "CAMEROON", "Yaounde" },
			{ "CAPE VERDE", "Praia" }, { "CENTRAL AFRICAN REPUBLIC", "Bangui" }, { "CHAD", "N'djamena" },
			{ "COMOROS", "Moroni" }, { "CONGO", "Brazzaville" }, { "DJIBOUTI", "Dijibouti" }, { "EGYPT", "Cairo" },
			{ "EQUATORIAL GUINEA", "Malabo" }, { "ERITREA", "Asmara" }, { "ETHIOPIA", "Addis Ababa" },
			{ "GABON", "Libreville" }, { "THE GAMBIA", "Banjul" }, { "GHANA", "Accra" }, { "GUINEA", "Conakry" },
			{ "BISSAU", "Bissau" }, { "COTE D'IVOIR (IVORY COAST)", "Yamoussoukro" }, { "KENYA", "Nairobi" },
			{ "LESOTHO", "Maseru" }, { "LIBERIA", "Monrovia" }, { "LIBYA", "Tripoli" },
			{ "MADAGASCAR", "Antananarivo" }, { "MALAWI", "Lilongwe" }, { "MALI", "Bamako" },
			{ "MAURITANIA", "Nouakchott" }, { "MAURITIUS", "Port Louis" }, { "MOROCCO", "Rabat" },
			{ "MOZAMBIQUE", "Maputo" }, { "NAMIBIA", "Windhoek" }, { "NIGER", "Niamey" }, { "NIGERIA", "Abuja" },
			{ "RWANDA", "Kigali" }, { "SAO TOME E PRINCIPE", "Sao Tome" }, { "SENEGAL", "Dakar" },
			{ "SEYCHELLES", "Victoria" }, { "SIERRA LEONE", "Freetown" }, { "SOMALIA", "Mogadishu" },
			{ "SOUTH AFRICA", "Pretoria/Cape Town" }, { "SUDAN", "Khartoum" }, { "SWAZILAND", "Mbabane" },
			{ "TANZANIA", "Dodoma" }, { "TOGO", "Lome" }, { "TUNISIA", "Tunis" }, { "UGANDA", "Kampala" },
			{ "DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)", "Kinshasa" }, { "ZAMBIA", "Lusaka" },
			{ "ZIMBABWE", "Harare" },
			// Asia
			{ "AFGHANISTAN", "Kabul" }, { "BAHRAIN", "Manama" }, { "BANGLADESH", "Dhaka" }, { "BHUTAN", "Thimphu" },
			{ "BRUNEI", "Bandar Seri Begawan" }, { "CAMBODIA", "Phnom Penh" }, { "CHINA", "Beijing" },
			{ "CYPRUS", "Nicosia" }, { "INDIA", "New Delhi" }, { "INDONESIA", "Jakarta" }, { "IRAN", "Tehran" },
			{ "IRAQ", "Baghdad" }, { "ISRAEL", "Jerusalem" }, { "JAPAN", "Tokyo" }, { "JORDAN", "Amman" },
			{ "KUWAIT", "Kuwait City" }, { "LAOS", "Vientiane" }, { "LEBANON", "Beirut" },
			{ "MALAYSIA", "Kuala Lumpur" }, { "THE MALDIVES", "Male" }, { "MONGOLIA", "Ulan Bator" },
			{ "MYANMAR (BURMA)", "Rangoon" }, { "NEPAL", "Katmandu" }, { "NORTH KOREA", "P'yongyang" },
			{ "OMAN", "Muscat" }, { "PAKISTAN", "Islamabad" }, { "PHILIPPINES", "Manila" }, { "QATAR", "Doha" },
			{ "SAUDI ARABIA", "Riyadh" }, { "SINGAPORE", "Singapore" }, { "SOUTH KOREA", "Seoul" },
			{ "SRI LANKA", "Colombo" }, { "SYRIA", "Damascus" }, { "TAIWAN (REPUBLIC OF CHINA)", "Taipei" },
			{ "THAILAND", "Bangkok" }, { "TURKEY", "Ankara" }, { "UNITED ARAB EMIRATES", "Abu Dhabi" },
			{ "VIETNAM", "Hanoi" }, { "YEMEN", "Sana'a" },
			// Australia and Oceania
			{ "AUSTRALIA", "Canberra" }, { "FIJI", "Suva" }, { "KIRIBATI", "Bairiki" },
			{ "MARSHALL ISLANDS", "Dalap-Uliga-Darrit" }, { "MICRONESIA", "Palikir" }, { "NAURU", "Yaren" },
			{ "NEW ZEALAND", "Wellington" }, { "PALAU", "Koror" }, { "PAPUA NEW GUINEA", "Port Moresby" },
			{ "SOLOMON ISLANDS", "Honaira" }, { "TONGA", "Nuku'alofa" }, { "TUVALU", "Fongafale" },
			{ "VANUATU", "< Port-Vila" }, { "WESTERN SAMOA", "Apia" },
			// Eastern Europe and former USSR
			{ "ARMENIA", "Yerevan" }, { "AZERBAIJAN", "Baku" }, { "BELARUS (BYELORUSSIA)", "Minsk" },
			{ "BULGARIA", "Sofia" }, { "GEORGIA", "Tbilisi" }, { "KAZAKSTAN", "Almaty" }, { "KYRGYZSTAN", "Alma-Ata" },
			{ "MOLDOVA", "Chisinau" }, { "RUSSIA", "Moscow" }, { "TAJIKISTAN", "Dushanbe" },
			{ "TURKMENISTAN", "Ashkabad" }, { "UKRAINE", "Kyiv" }, { "UZBEKISTAN", "Tashkent" },
			// Europe
			{ "ALBANIA", "Tirana" }, { "ANDORRA", "Andorra la Vella" }, { "AUSTRIA", "Vienna" },
			{ "BELGIUM", "Brussels" }, { "BOSNIA", "-" }, { "HERZEGOVINA", "Sarajevo" }, { "CROATIA", "Zagreb" },
			{ "CZECH REPUBLIC", "Prague" }, { "DENMARK", "Copenhagen" }, { "ESTONIA", "Tallinn" },
			{ "FINLAND", "Helsinki" }, { "FRANCE", "Paris" }, { "GERMANY", "Berlin" }, { "GREECE", "Athens" },
			{ "HUNGARY", "Budapest" }, { "ICELAND", "Reykjavik" }, { "IRELAND", "Dublin" }, { "ITALY", "Rome" },
			{ "LATVIA", "Riga" }, { "LIECHTENSTEIN", "Vaduz" }, { "LITHUANIA", "Vilnius" },
			{ "LUXEMBOURG", "Luxembourg" }, { "MACEDONIA", "Skopje" }, { "MALTA", "Valletta" }, { "MONACO", "Monaco" },
			{ "MONTENEGRO", "Podgorica" }, { "THE NETHERLANDS", "Amsterdam" }, { "NORWAY", "Oslo" },
			{ "POLAND", "Warsaw" }, { "PORTUGAL", "Lisbon" }, { "ROMANIA", "Bucharest" },
			{ "SAN MARINO", "San Marino" }, { "SERBIA", "Belgrade" }, { "SLOVAKIA", "Bratislava" },
			{ "SLOVENIA", "Ljuijana" }, { "SPAIN", "Madrid" }, { "SWEDEN", "Stockholm" }, { "SWITZERLAND", "Berne" },
			{ "UNITED KINGDOM", "London" }, { "VATICAN CITY", "---" },
			// North and Central America
			{ "ANTIGUA AND BARBUDA", "Saint John's" }, { "BAHAMAS", "Nassau" }, { "BARBADOS", "Bridgetown" },
			{ "BELIZE", "Belmopan" }, { "CANADA", "Ottawa" }, { "COSTA RICA", "San Jose" }, { "CUBA", "Havana" },
			{ "DOMINICA", "Roseau" }, { "DOMINICAN REPUBLIC", "Santo Domingo" }, { "EL SALVADOR", "San Salvador" },
			{ "GRENADA", "Saint George's" }, { "GUATEMALA", "Guatemala City" }, { "HAITI", "Port-au-Prince" },
			{ "HONDURAS", "Tegucigalpa" }, { "JAMAICA", "Kingston" }, { "MEXICO", "Mexico City" },
			{ "NICARAGUA", "Managua" }, { "PANAMA", "Panama City" }, { "ST. KITTS", "-" }, { "NEVIS", "Basseterre" },
			{ "ST. LUCIA", "Castries" }, { "ST. VINCENT AND THE GRENADINES", "Kingstown" },
			{ "UNITED STATES OF AMERICA", "Washington, D.C." },
			// South America
			{ "ARGENTINA", "Buenos Aires" }, { "BOLIVIA", "Sucre (legal)/La Paz(administrative)" },
			{ "BRAZIL", "Brasilia" }, { "CHILE", "Santiago" }, { "COLOMBIA", "Bogota" }, { "ECUADOR", "Quito" },
			{ "GUYANA", "Georgetown" }, { "PARAGUAY", "Asuncion" }, { "PERU", "Lima" }, { "SURINAME", "Paramaribo" },
			{ "TRINIDAD AND TOBAGO", "Port of Spain" }, { "URUGUAY", "Montevideo" }, { "VENEZUELA", "Caracas" }, };

	// Use AbstractMap by implementing entrySet()
	public static class FlyWeightMap extends AbstractMap<String , String>{
		
		private class Entry implements Map.Entry<String , String>{
			int index;
			private Entry(int index){
				this.index = index;
			}
			@Override
			public String getKey() {
				// TODO Auto-generated method stub
				return DATA[index][0];
			}

			@Override
			public String getValue() {
				// TODO Auto-generated method stub
				return DATA[index][1];
			}

			@Override
			public String setValue(String value) {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}
			
			@Override
			public boolean equals(Object obj) {
				// TODO Auto-generated method stub
				return DATA[index][0].equals(obj);
			}
			
			@Override
			public int hashCode() {
				// TODO Auto-generated method stub
				return DATA[index][0].hashCode();
			}
			
		}
		
		class EntrySet extends AbstractSet<Map.Entry<String , String>>{
			private int size;
			private EntrySet(int size){
				if (size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}
			
			Entry entry = new Entry(-1);
			
			private class Iter implements Iterator<Map.Entry<String , String>>{
				private int ite = 0;
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return entry.index < size - 1;
				}

				@Override
				public java.util.Map.Entry<String, String> next() {
					// TODO Auto-generated method stub
					entry.index++;
					return entry;
				}
				
			}

			@Override
			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				// TODO Auto-generated method stub
				return new Iter();
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return size;
			}
			
		}
		
		private Set<Map.Entry<String , String>> entrySet = new EntrySet(DATA.length);
		
		@Override
		public Set<java.util.Map.Entry<String, String>> entrySet() {
			// TODO Auto-generated method stub
			return entrySet;
		}
		
	}
	
	
	
	
	static Map<String , String> map = new FlyWeightMap();
	
	private static Map<String , String> select(int size){
		return new FlyWeightMap(){
			@Override
			public Set<java.util.Map.Entry<String, String>> entrySet() {
				// TODO Auto-generated method stub
				EntrySet es = new EntrySet(size);
//				FlyWeightMap map = new FlyWeightMap();
//				FlyWeightMap.EntrySet es = map.new EntrySet(size);
				return es;
			}
		};
	}
	
	public static Map<String , String> capitals(){
		return map;
	}
	
	public static Map<String , String> capitals(int size){
		return select(size);
	}
	
	static List<String> names = new ArrayList<String>(map.keySet());
	
	public static List<String> names(){
		return names;
	}
	
	public static List<String> names(int size){
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
		System.out.println(capitals(10));
		System.out.println(names(10));
	}
	
	
} 

/*
	 * Output: {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo,
	 * BOTSWANA=Gaberone, BULGARIA=Sofia, BURKINA FASO=Ouagadougou,
	 * BURUNDI=Bujumbura, CAMEROON=Yaounde, CAPE VERDE=Praia, CENTRAL AFRICAN
	 * REPUBLIC=Bangui} [ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA
	 * FASO, BURUNDI, CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC]
	 * {BENIN=Porto-Novo, ANGOLA=Luanda, ALGERIA=Algiers} {ALGERIA=Algiers,
	 * ANGOLA=Luanda, BENIN=Porto-Novo} {ALGERIA=Algiers, ANGOLA=Luanda,
	 * BENIN=Porto-Novo} {ALGERIA=Algiers, ANGOLA=Luanda, BENIN=Porto-Novo}
	 * [BULGARIA, BURKINA FASO, BOTSWANA, BENIN, ANGOLA, ALGERIA] [ALGERIA,
	 * ANGOLA, BENIN, BOTSWANA, BULGARIA, BURKINA FASO] [ALGERIA, ANGOLA, BENIN,
	 * BOTSWANA, BULGARIA, BURKINA FASO] [ALGERIA, ANGOLA, BENIN, BOTSWANA,
	 * BULGARIA, BURKINA FASO] [ALGERIA, ANGOLA, BENIN, BOTSWANA, BULGARIA,
	 * BURKINA FASO] Brasilia
	 */// :~
