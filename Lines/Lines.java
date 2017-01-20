package Lines;

import Port.*;
import shape.*;

public class Lines extends shape {
	Port start, end;

	public void setSPort(Port start) {
		this.start = start;
	}

	public void setEPort(Port end) {
		this.end = end;
	}

	public Port getSPort() {
		return start;
	}

	public Port getEPort() {
		return end;
	}
}
