% postprocessing

figure(1)
clf
plot(out.x(:,1), out.x(:, 2), 'b*')
hold on
plot(out.x(1,1), out.x(1, 2), 'r*')
xlabel('x1')
xlabel('x2')