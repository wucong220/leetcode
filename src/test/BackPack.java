package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BackPack {
	static Map<String, Integer[]> vir_server_cfg= new HashMap<String,Integer[]>();
	static{
		vir_server_cfg.put("flavor1", new Integer[] { 1, 1024 });
		vir_server_cfg.put("flavor2", new Integer[] { 1, 2048 });
		vir_server_cfg.put("flavor3", new Integer[] { 1, 4096 });
		vir_server_cfg.put("flavor4", new Integer[] { 2, 2048 });
		vir_server_cfg.put("flavor5", new Integer[] { 2, 4096 });
		vir_server_cfg.put("flavor6", new Integer[] { 2, 8192 });
		vir_server_cfg.put("flavor7", new Integer[] { 4, 4096 });
		vir_server_cfg.put("flavor8", new Integer[] { 4, 8192 });
		vir_server_cfg.put("flavor9", new Integer[] { 4, 16384 });
		vir_server_cfg.put("flavor10", new Integer[] { 8, 8192 });
		vir_server_cfg.put("flavor11", new Integer[] { 8, 16384 });
		vir_server_cfg.put("flavor12", new Integer[] { 8, 32768 });
		vir_server_cfg.put("flavor13", new Integer[] { 16, 16384 });
		vir_server_cfg.put("flavor14", new Integer[] { 16, 32768 });
		vir_server_cfg.put("flavor15", new Integer[] { 16, 65536 });

	}

	static public void find_FirstFit(List<Phy_server> phy_servers, String vir_server_name, int total_phy_server_cpu,
			int total_phy_server_mem) {
		int vir_server_cpu = vir_server_cfg.get(vir_server_name)[0];
		int vir_server_mem = vir_server_cfg.get(vir_server_name)[1];

		for (int i = 0; i < phy_servers.size(); i++) {
			Phy_server phy_server = phy_servers.get(i);
			int phy_server_cpu = phy_server.getPhy_server_cpu();
			int phy_server_mem = phy_server.getPhy_server_mem();

			if (phy_server_cpu >= vir_server_cpu && phy_server_mem >= vir_server_mem) {
				
				phy_server.setPhy_server_cpu(phy_server_cpu - vir_server_cpu);
				phy_server.setPhy_server_mem(phy_server_mem - vir_server_mem);

				Map<String, Integer> vir_servers = phy_server.getVir_servers();

				if (null == vir_servers.get(vir_server_name)) {
					vir_servers.put(vir_server_name, 1);
				} else {
					vir_servers.put(vir_server_name, vir_servers.get(vir_server_name) + 1);
				}
				phy_servers.set(i, phy_server);
				return;
			}
		}

		Phy_server phy_server = new Phy_server(total_phy_server_cpu - vir_server_cpu,
				total_phy_server_mem - vir_server_mem);
		Map<String, Integer> vir_servers = new HashMap<String, Integer>();
		vir_servers.put(vir_server_name, 1);
		phy_server.setVir_servers(vir_servers);

	}

	static public List<Phy_server> putIn(int phy_server_cpu, int phy_server_mem, Map<String, Integer> vir_servers) {

		List<Phy_server> phy_servers = new ArrayList<Phy_server>();

		Iterator<String> iterator = vir_servers.keySet().iterator();
		while (iterator.hasNext()) {
			String vir_server_name = iterator.next();
			int vir_server_num = vir_servers.get(vir_server_name);
			for (int i = 0; i < vir_server_num; i++) {
				find_FirstFit(phy_servers, vir_server_name, phy_server_cpu, phy_server_mem);
			}
		}
		return phy_servers;
	}
	
	static public String[] result(List<Phy_server> phy_servers){
		List<String> ret = new ArrayList<String>();
		ret.add(String.valueOf(phy_servers.size()));
		for(int i = 1; i<=phy_servers.size();i++){
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			Phy_server phy_server = phy_servers.get(i);
			Map<String, Integer> vir_servers = phy_server.getVir_servers();
			Iterator<String> iterator = vir_servers.keySet().iterator();
			while(iterator.hasNext()){
				String vir_server_name=iterator.next();
				sb.append(" ");
				sb.append(vir_server_name);
				sb.append(" ");
				sb.append(vir_servers.get(vir_server_name));
			}
			ret.add(sb.toString());
		}
		
		
		return ret.toArray(new String[1]);
	}
}

class Phy_server {
	private int phy_server_cpu;
	private int phy_server_mem;
	private Map<String, Integer> vir_servers;

	public Phy_server(int phy_server_cpu, int phy_server_mem) {
		super();
		this.phy_server_cpu = phy_server_cpu;
		this.phy_server_mem = phy_server_mem;
	}

	public int getPhy_server_cpu() {
		return phy_server_cpu;
	}

	public void setPhy_server_cpu(int phy_server_cpu) {
		this.phy_server_cpu = phy_server_cpu;
	}

	public int getPhy_server_mem() {
		return phy_server_mem;
	}

	public void setPhy_server_mem(int phy_server_mem) {
		this.phy_server_mem = phy_server_mem;
	}

	public Map<String, Integer> getVir_servers() {
		return vir_servers;
	}

	public void setVir_servers(Map<String, Integer> vir_servers) {
		this.vir_servers = vir_servers;
	}

}
