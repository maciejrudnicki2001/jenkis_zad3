package com.example.backendzad3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PointController {

        private final PointService pointService;

        @Autowired
        public PointController(PointService pointService) {
            this.pointService = pointService;
        }

        @GetMapping("/")
        public ResponseEntity<Point[]> getAllPoints(){
            return ResponseEntity.ok(pointService.getAllPoints());
        }

        @GetMapping("/{n}")
        public ResponseEntity<Point[]> getFirstNPoints(@PathVariable int n){
            if (n > pointService.getAllPoints().length){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(pointService.getFirstNPoints(n));
        }

        @GetMapping("/distance/{x1}/{y1}/{x2}/{y2}")
        public ResponseEntity<Double> getDistance(@PathVariable int x1, @PathVariable int y1, @PathVariable int x2, @PathVariable int y2){
            return ResponseEntity.ok(pointService.getDistance(x1, y1, x2, y2));
        }

        @PostMapping("/add/{x}/{y}")
        public ResponseEntity<Point[]> addPoint(@PathVariable int x, @PathVariable int y){
            pointService.addPoint(new Point(x, y));
            return ResponseEntity.ok(pointService.getAllPoints());
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deletePoint(@PathVariable int id){
            return ResponseEntity.ok(pointService.deletePoint(id));
        }


}
